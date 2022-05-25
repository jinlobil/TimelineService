package com.sparta.week03.service;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // final 생성된 녀석이 있으면 그거 생성할떄 같이 넣어줄게
@Service //스프링아 얘는 서비스야
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional // 이게 진짜 db에 방영이 되야해!
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();


    }


}
