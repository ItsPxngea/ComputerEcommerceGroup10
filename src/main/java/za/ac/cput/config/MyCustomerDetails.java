package za.ac.cput.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import za.ac.cput.domain.Customer;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyCustomerDetails implements UserDetails {
    private Customer customer;
    private Collection<? extends GrantedAuthority> authorities;

    public MyCustomerDetails(Customer customer, Collection<? extends GrantedAuthority> authorities){
        this.customer = customer;
        this.authorities = authorities;
    }

    public static MyCustomerDetails createCustomer(Customer customer){
        List<GrantedAuthority> authorities = customer.getRole().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());

        return new MyCustomerDetails(customer, authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return authorities;
    }

    @Override
    public String getPassword() {
        return customer.getPassword();
    }

    @Override
    public String getUsername() {
        return customer.getEmail();
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
