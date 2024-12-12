package com.primeira.appSpring.model;

public class M_Resposta {
    private boolean sucesso;
    private String mensagen;

    public M_Resposta(){
        this.sucesso = false;
        this.mensagen = "";
    }

    public M_Resposta(boolean sucesso, String mensagen) {
        this.sucesso = sucesso;
        this.mensagen = mensagen;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMensagen() {
        return mensagen;
    }

    public void setMensagen(String mensagen) {
        this.mensagen = mensagen;
    }
}
