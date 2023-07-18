package com.jellybean.api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name="members")
@NamedEntityGraph(name = "Member.withRoles", attributeNodes = @NamedAttributeNode("roleSet"))
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "roleSet")
@Builder
public class Member implements UserDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private boolean del;

    @Column(nullable = false)
    private LocalDate regDate;

    @Column
    private LocalDate modDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
//    private UserType userType;
    private Set<MemberRole> roleSet = new HashSet<>();

    public Member(String name, String email, String encode, LocalDate dateOfBirth, String phoneNumber, boolean del, LocalDate regDate, MemberRole roleSet) {
    }

    public void changePassword(String password){
        this.password = password;
    }

    public void changeDel(boolean del){
        this.del = del;
    }

    public void addRole(MemberRole roleSet){
        this.roleSet.add(roleSet);
    }

    public void clearRoles() {
        this.roleSet.clear();
    }

    public static Member createMember(String name, String email, String password, PasswordEncoder passwordEncoder, LocalDate dateOfBirth, String phoneNumber, boolean del, LocalDate regDate, MemberRole roleSet){
        return new Member(name, email, passwordEncoder.encode(password), dateOfBirth, phoneNumber, del, regDate, roleSet);
    }

    @Builder
    public Member(Long id, String name, String email, String password, LocalDate dateOfBirth, String phoneNumber, boolean del, LocalDate regDate, LocalDate modDate, Set<MemberRole> roleSet) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.del = del;
        this.regDate = regDate;
        this.modDate = modDate;
        this.roleSet = roleSet;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roleSet.stream()
                .map(role-> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
