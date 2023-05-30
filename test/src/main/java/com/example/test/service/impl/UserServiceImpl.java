package com.example.test.service.impl;

import com.example.test.dto.UserResponse;
import com.example.test.entity.Company;
import com.example.test.entity.User;
import com.example.test.repository.CompanyRepository;
import com.example.test.repository.UserRepository;
import com.example.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    @Override
    public void getOne(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            Company company = userOptional.get().getCompany();
            System.out.println(company.getId());
            System.out.println(company.getName());
        }
    }

    @Override
    public List<UserResponse> getAll() {
        List<User> list = userRepository.findAll();

        List<UserResponse> responses = new ArrayList<>();
        for (User u: list) {
            responses.add(UserResponse.builder()
                    .name(u.getName())
                    .companyName(u.getCompany().getName())
                    .build());
        }

        return responses;
    }

    @Override
    public void add() {
        Company company = new Company();
        company.setName("Tien Company");

        Company save = companyRepository.save(company);

        User user = new User();
        user.setCompany(save);
        user.setName("Tien");

        userRepository.save(user);
    }
}
