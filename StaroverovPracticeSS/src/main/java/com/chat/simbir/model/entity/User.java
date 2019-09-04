package com.chat.simbir.model.entity;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "usr")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(unique = true)
    private String username;

    @NonNull
    private String password;

    @NonNull
    private boolean enable;

    @OneToMany(targetEntity = Message.class, mappedBy = "user", orphanRemoval = false, fetch = FetchType.LAZY)
    protected Set<Message> messages;

    @OneToMany(targetEntity = RoomUserRole.class, mappedBy = "user", orphanRemoval = false, fetch = FetchType.LAZY)
    protected Set<RoomUserRole> roomUserRoles;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; //Если указать getRoles() автоматически подхватывать роли нужные для Spring Securritu и он сам будет их обрабатывать и давать доступ к задекларированныи в Security конфинге  страницам сайта
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnable();
    }

}
