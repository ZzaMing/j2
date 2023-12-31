package org.zerock.j2.service;

import jakarta.transaction.Transactional;
import org.zerock.j2.dto.MemberCartDTO;
import org.zerock.j2.entity.MemberCart;

import java.util.List;

@Transactional
public interface MemberCartService {

    List<MemberCartDTO> addCart(MemberCartDTO memberCartDTO);

    List<MemberCartDTO> getCart(String email);

    default MemberCart dtoToEntity(MemberCartDTO dto) {
        return MemberCart.builder()
                .cno(dto.getCno())
                .email(dto.getEmail())
                .pno(dto.getPno())
                .build();
    }

    default MemberCartDTO entityToDTO(MemberCart entity) {
        return MemberCartDTO.builder()
                .cno(entity.getCno())
                .email(entity.getEmail())
                .pno(entity.getPno())
                .build();
    }

}
