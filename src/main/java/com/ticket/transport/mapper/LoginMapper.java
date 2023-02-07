package com.ticket.transport.mapper;

import com.ticket.transport.config.security.UserDetailsImpl;
import com.ticket.transport.model.response.LoginResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        config = ConfigurationMapper.class)

public interface LoginMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    LoginResponse mapUserDetailsImplToLoginResponse(UserDetailsImpl userDetails);
}
