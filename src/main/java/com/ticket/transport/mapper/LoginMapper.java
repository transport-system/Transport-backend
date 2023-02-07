package com.ticket.transport.mapper;

import com.ticket.transport.config.security.UserDetailsImpl;
import com.ticket.transport.model.response.LoginResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(config = ConfigurationMapper.class, componentModel="spring")
public interface LoginMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    LoginResponse mapUserDetailsImplToLoginResponse(UserDetailsImpl userDetails);
}
