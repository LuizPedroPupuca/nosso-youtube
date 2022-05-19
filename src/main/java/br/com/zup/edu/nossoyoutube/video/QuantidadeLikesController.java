package br.com.zup.edu.nossoyoutube.video;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class QuantidadeLikesController {

    private final VideoRepository videoRepository;

    public QuantidadeLikesController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @PatchMapping("/incrementa-gostei-likes/{id}")
    public ResponseEntity<?> incrementa(@PathVariable Long id){
        Video video = videoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vídeo não encontrado!!!"));
        video.incrementaGostei();
        videoRepository.save(video);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/incrementa-naogostei-likes/{id}")
    public ResponseEntity<?> descrementa(@PathVariable Long id){
        Video video = videoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vídeo não encontrado!!!"));
        video.incrementaNaoGostei();
        videoRepository.save(video);
        return ResponseEntity.noContent().build();
    }
}
