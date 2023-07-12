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
    String message_id;
    String conversacion_id;
    String remitente_id;
    String receptor_id;
    String mensaje_texto;
    String fecha_envio;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage_id() {
        return this.message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getConversacion_id() {
        return this.conversacion_id;
    }

    public void setConversacion_id(String conversacion_id) {
        this.conversacion_id = conversacion_id;
    }

    public String getRemitente_id() {
        return this.remitente_id;
    }

    public void setRemitente_id(String remitente_id) {
        this.remitente_id = remitente_id;
    }

    public String getReceptor_id() {
        return this.receptor_id;
    }

    public void setReceptor_id(String receptor_id) {
        this.receptor_id = receptor_id;
    }

    public String getMensaje_texto() {
        return this.mensaje_texto;
    }

    public void setMensaje_texto(String mensaje_texto) {
        this.mensaje_texto = mensaje_texto;
    }

    public String getFecha_envio() {
        return this.fecha_envio;
    }

    public void setFecha_envio(String fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    @Override
    public String toString() {
        return "Message [message_id=" + message_id + ", conversacion_id=" + conversacion_id + ", remitente_id="
                + remitente_id + ", receptor_id=" + receptor_id + ", mensaje_texto=" + mensaje_texto + ", fecha_envio="
                + fecha_envio + "]";
    }
}
