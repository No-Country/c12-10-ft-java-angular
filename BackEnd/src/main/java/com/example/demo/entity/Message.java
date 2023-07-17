package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "message")
public class Message {
    /*
     * {
     * "message_id": 1,
     * "conversacion_id": 100,
     * "remitente_id": 10,
     * "receptor_id": 20,
     * "mensaje_texto": "Hola, ¿cómo estás?",
     * "fecha_envio": "2023-07-01"
     * },
     */
    String id;
    String messageId;
    String conversacionId;
    String remitenteId;
    String receptorId;
    String mensajeTexto;
    String fechaEnvio;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getConversacionId() {
        return this.conversacionId;
    }

    public void setConversacionId(String conversacionId) {
        this.conversacionId = conversacionId;
    }

    public String getRemitenteId() {
        return this.remitenteId;
    }

    public void setRemitenteId(String remitenteId) {
        this.remitenteId = remitenteId;
    }

    public String getReceptorId() {
        return this.receptorId;
    }

    public void setReceptorId(String receptorId) {
        this.receptorId = receptorId;
    }

    public String getMensajeTexto() {
        return this.mensajeTexto;
    }

    public void setMensajeTexto(String mensajeTexto) {
        this.mensajeTexto = mensajeTexto;
    }

    public String getFechaEnvio() {
        return this.fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", messageId='" + getMessageId() + "'" +
                ", conversacionId='" + getConversacionId() + "'" +
                ", remitenteId='" + getRemitenteId() + "'" +
                ", receptorId='" + getReceptorId() + "'" +
                ", mensajeTexto='" + getMensajeTexto() + "'" +
                ", fechaEnvio='" + getFechaEnvio() + "'" +
                "}";
    }

}
