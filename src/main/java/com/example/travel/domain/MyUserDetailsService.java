package com.example.travel.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.travel.security.ApplicationUserRol.ADMIN;
import static com.example.travel.security.ApplicationUserRol.GUEST;


@Service
public class MyUserDetailsService implements UserDetailsService {

    private final String stockAvatar = "https://media.istockphoto.com/vectors/default-profile-picture-avatar-photo-placeholder-vector-illustration-vector-id1223671392?k=20&m=1223671392&s=612x612&w=0&h=lGpj2vWAI3WUT1JeJWm1PRoHT3V15_1pdcTn2szdwQ0=";
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordConfig passwordConfig;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<ApplicationUser> byUsername = userRepository.findByUsername(username);
        if(byUsername.isPresent()){
           return byUsername.get();
        }
        throw new UsernameNotFoundException(username);
    }

    public UserDetails registerNewUser(UserDTO userDTO) throws Exception {
        String imgUrl = stockAvatar;
        if(userExistByName(userDTO.getUsername())){
            throw new Exception("User already exists");
        }
        if(!passwordConfirm(userDTO.getPassword(),userDTO.getPasswordConfirm())){
            throw new Exception("Password not equals");
        }
        if(!userDTO.getImgUrl().isEmpty()){
            imgUrl = userDTO.getImgUrl();
        }
        ApplicationUser user = new ApplicationUser(userDTO.getUsername(),passwordConfig.passwordEncoder().encode(userDTO.getPassword()),imgUrl,GUEST
                .getGrantedAuthorities());
        return userRepository.save(user);
    }

    public ApplicationUser getUserById(long id){
        Optional<ApplicationUser> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public void updateUserAvatar(String imgUrl, String username) throws Exception {
        if(!userExistByName(username)){
            throw new Exception("User dont exist!");
        }
        ApplicationUser user = userRepository.findByUsername(username).get();
        user.setImgUrl(imgUrl);
        userRepository.save(user);
    }

    public String getUserAvatar(String username)  {
        String userAvatar = "";
        if(userExistByName(username)){
            ApplicationUser user = userRepository.findByUsername(username).get();
            userAvatar = user.getImgUrl();
        }
        return userAvatar;
    }

    public String getUserId(String username)  {
        String userId = "";
        if(userExistByName(username)){
            ApplicationUser user = userRepository.findByUsername(username).get();
            userId = user.getId().toString();
        }
        return userId;
    }

    public boolean isAdmin(long id){
        Optional<ApplicationUser> user = this.userRepository.findById(id);
        if(user.isPresent()){
            return user.get().getGrantedAuthorities().stream().anyMatch((a)->a.getAuthority().equalsIgnoreCase("ROLE_ADMIN"));
        }
        return false;
    }

    private boolean userExistByName(String username){
        return userRepository.findByUsername(username).isPresent();
    }

    private boolean passwordConfirm(String password,String passwordConfirm){
        return password.equals(passwordConfirm);
    }
}
