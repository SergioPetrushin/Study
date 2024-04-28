package ru.study.study.entity.user;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.study.study.entity.BaseEntity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity(name = "USERS")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "USER_ID"))
public class User extends BaseEntity implements UserDetails {

    @Serial
    private static final long serialVersionUID = 1L;

    public User(Long id) {
        this.id = id;
    }

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "EMAIL_CODE")
    private UUID emailCode;

    @Column(name = "PWD_CODE")
    private UUID pwdCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_TYPE_ID")
    private UserType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_STATUS_ID")
    private UserStatus status;


    @Override
    public User setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public User setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public User setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(UserTypeEnum.getById(type.getId()).name()));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return  UserStatusEnum.getById(status.getId()).equals(UserStatusEnum.ACTIVE);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return UserStatusEnum.getById(status.getId()).equals(UserStatusEnum.ACTIVE);
    }
}
