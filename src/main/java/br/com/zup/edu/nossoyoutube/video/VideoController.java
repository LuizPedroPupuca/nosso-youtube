package br.com.zup.edu.nossoyoutube.video;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class VideoController {

    private final VideoRepository videoRepository;

    public VideoController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @PostMapping("/cadastra-video")
    public ResponseEntity<?> cadastra(@RequestBody VideoRequest videoRequest, UriComponentsBuilder uriComponentsBuilder){
        Video video = videoRequest.toModel();
        videoRepository.save(video);

        URI location = uriComponentsBuilder.path("/video/{id}")
                .buildAndExpand(video.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @PatchMapping("/atualiza-video/{id}")
    public ResponseEntity<?> atualiza(@RequestBody VideoRequest videoRequest, @PathVariable Long id){
        Video video = videoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vídeo não encontrado!!!"));
        video.atualiza(videoRequest);
        videoRepository.save(video);
        return ResponseEntity.noContent().build();
    }
}
