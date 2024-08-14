package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //jpa entity클래스들이 상속될경우 필드들도 칼럼으로 인식하게 합니다
@EntityListeners(AuditingEntityListener.class) //basetimeentity 클래스에 auditing 기능을 포함시킵니다.
public abstract class BaseTimeEntity {

    @CreatedDate //entity가 생성되어 저장될 때 시간이 자동 저장됩니다
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
