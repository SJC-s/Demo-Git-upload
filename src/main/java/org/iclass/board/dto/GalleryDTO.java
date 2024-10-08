package org.iclass.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iclass.board.entity.GalleryEntity;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GalleryDTO {
    private int idx;
    private String title;
    private String fileNames; // 테이블에는 업로드파일의 파일명을 저장
    private String writer;
    private LocalDateTime createdAt;

    // 업로드 파일을 저장하기 위한 객체
    private MultipartFile file;

    // GalleryDTO.of() : entity 인자로 DTO 생성 - 조회 find~~ 메소드 결과 리턴타입이 entity
    public static GalleryDTO of(GalleryEntity entity) {
        return GalleryDTO.builder()
                .idx(entity.getIdx())
                .title(entity.getTitle())
                .fileNames(entity.getFilenames())
                .writer(entity.getWriter())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    // 인스턴스객체.toEntity() : 현재 객체를 인스턴스값으로 entity 객체 생성 - save, saveAll, delete 메소드 인자 entity
    public GalleryEntity toEntity() {
        return GalleryEntity.builder()   // return new GalleryEntity(,,,) ; 생성자는 순서 맞추기가 어렵다
                .idx(this.idx)
                .title(this.title)
                .filenames(this.fileNames)
                .writer(this.writer)
                //.createdAt(createdAt)  // createdAt은 auditing 필드이므로 제외
                .build();
    }
}
