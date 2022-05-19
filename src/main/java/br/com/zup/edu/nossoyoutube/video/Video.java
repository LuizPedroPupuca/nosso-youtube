package br.com.zup.edu.nossoyoutube.video;

import javax.persistence.*;

@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String link;
    @Column(nullable = false)
    private Integer visualizacoes;
    @OneToOne(mappedBy = "video", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeLikes quantidadeLikes;

    @Version
    private int version;

    public Video(String titulo, String descricao, String link, Integer visualizacoes) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.link = link;
        this.visualizacoes = visualizacoes;
        this.quantidadeLikes = new QuantidadeLikes(this);
    }

    public void incrementaGostei(){
        this.quantidadeLikes.incrementaGostei();
    }

    public void incrementaNaoGostei(){
        this.quantidadeLikes.incrementaNaoGostei();
    }

    public void atualiza(VideoRequest videoRequest){
        this.titulo = videoRequest.getTitulo();
        this.descricao = videoRequest.getDescricao();
        this.link = videoRequest.getLink();
        this.visualizacoes = videoRequest.getVisualizacoes();
    }

    /**
     * @deprecated
     */
    @Deprecated
    public Video() {
    }

    public Long getId() {
        return id;
    }
}
