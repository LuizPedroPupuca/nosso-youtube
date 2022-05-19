package br.com.zup.edu.nossoyoutube.video;

import javax.persistence.*;

@Entity
public class QuantidadeLikes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer gostei;//joinha para cima

    @Column(nullable = false)
    private Integer naoGostei;//joinha para baixo

    @OneToOne
    private Video video;

    @Version
    private int version;

    @Deprecated
    public QuantidadeLikes() {
    }

    public QuantidadeLikes(Video video) {
        this.gostei = 0;
        this.naoGostei = 0;
        this.video = video;
    }

    public void incrementaGostei(){
        gostei++;
    }

    public void incrementaNaoGostei(){
        naoGostei++;
    }

    public Long getId() {
        return id;
    }
}
