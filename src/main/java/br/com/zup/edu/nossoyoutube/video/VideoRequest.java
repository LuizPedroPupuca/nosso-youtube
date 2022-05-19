package br.com.zup.edu.nossoyoutube.video;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VideoRequest {

    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotBlank
    private String link;
    @NotNull
    private Integer visualizacoes;


    public VideoRequest() {
    }

    public VideoRequest(String titulo, String descricao, String link, Integer visualizacoes) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.link = link;
        this.visualizacoes = visualizacoes;
    }

    public Video toModel() {
        return new Video(titulo, descricao, link, visualizacoes);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLink() {
        return link;
    }

    public Integer getVisualizacoes() {
        return visualizacoes;
    }

}
