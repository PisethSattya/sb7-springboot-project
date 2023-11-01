package co.devkh.onlinestore.init;

import co.devkh.onlinestore.api.product.Category;
import co.devkh.onlinestore.api.product.CategoryRepository;
import co.devkh.onlinestore.api.user.Authority;
import co.devkh.onlinestore.api.user.AuthorityRepository;
import co.devkh.onlinestore.api.user.Role;
import co.devkh.onlinestore.api.user.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInit {
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;
    private final CategoryRepository categoryRepository;

    @PostConstruct
    public void init(){
//
//        // Staff-Authorities-Management
//        Authority readProduct = Authority.builder().name("product:read").build();
//        Authority writeProduct = Authority.builder().name("product:write").build();
//        Authority deleteProduct = Authority.builder().name("product:delete").build();
//        Authority updateProduct = Authority.builder().name("product:update").build();
//        Set<Authority> productAuthorities = Set.of(readProduct,writeProduct,deleteProduct,updateProduct);
//        authorityRepository.saveAll(productAuthorities);
//
//        // User-Authorities-Management
//        Authority readUser = Authority.builder().name("user:read").build();
//        Authority writeUser = Authority.builder().name("user:write").build();
//        Authority deleteUser = Authority.builder().name("user:delete").build();
//        Authority updateUser = Authority.builder().name("user:update").build();
//        Authority userProfile = Authority.builder().name("user:profile").build();
//        Set<Authority> userAuthorities = Set.of(readUser,writeUser,deleteUser,updateUser,userProfile);
//        authorityRepository.saveAll(userAuthorities);
//
//        // Combine Authorities (Staff + User)
//        Set<Authority> fullAuthorities = new HashSet<>(){{
//            addAll(productAuthorities);
//            addAll(userAuthorities);
//        }};
//
//
//
//        // Role Management : Admin,Staff,Customer
//
//        Role adminRole = Role.builder()
//                .name("ADMIN")
//                .authorities(fullAuthorities)
//                .build();
//
//        Role staffRole = Role.builder()
//                .name("STAFF")
//                .authorities(new HashSet<>(){{
//                    addAll(productAuthorities);
//                    add(userProfile);
//                }})
//                .build();
//
//        Role customerRole = Role.builder()
//                .name("CUSTOMER")
//                .authorities(Set.of(readProduct,userProfile))
//                .build();
//
//        roleRepository.saveAll(List.of(adminRole,staffRole,customerRole));
//
//
//        categoryRepository.save(Category.builder()
//                .name("Electronic")
//                .description("Electronic")
//                .build());
//        categoryRepository.save(Category.builder()
//                .name("Technologies")
//                .description("Technologies")
//                .build());
//        categoryRepository.save(Category.builder()
//                .name("LifeStyles")
//                .description("LifeStyles")
//                .build());
    }
}
