package com.microservices.dao;

import com.microservices.models.Resena;
import com.mongodb.client.MongoCollection;
import org.bson.Document;



import com.microservices.config.MongoDatabaseConnection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;


public class ResenaDAO {
    private final MongoCollection<Document> collection;

    public ResenaDAO() {
        MongoDatabase database = MongoDatabaseConnection.getInstance().getDatabase();
        this.collection = database.getCollection("resenas");
    }

    public Resena save(Resena resena) {
        Document doc = new Document();

        if (resena.getId() != null) {
            doc.append("_id", resena.getId());
        }

        doc.append("habitacionId", resena.getHabitacionId())
                .append("usuarioId", resena.getUsuarioId())
                .append("fecha", resena.getFecha())
                .append("calificacion", resena.getCalificacion())
                .append("comentario", resena.getComentario());

        if (resena.getId() == null) {
            collection.insertOne(doc);
            resena.setId(doc.getObjectId("_id"));
        } else {
            collection.replaceOne(Filters.eq("_id", resena.getId()), doc);
        }

        return resena;
    }

    public List<Resena> findAll() {
        List<Resena> resenas = new ArrayList<>();
        for (Document doc : collection.find()) {
            resenas.add(documentToResena(doc));
        }
        return resenas;
    }

    private Resena documentToResena(Document doc) {
        if (doc == null) {
            return null;
        }

        Resena resena = new Resena();
        resena.setId(doc.getObjectId("_id"));
        resena.setHabitacionId(doc.getInteger("habitacionId"));
        resena.setUsuarioId(doc.getInteger("usuarioId"));
        resena.setFecha(doc.getDate("fecha"));
        resena.setCalificacion(doc.getInteger("calificacion"));
        resena.setComentario(doc.getString("comentario"));

        return resena;
    }

    public List<Resena> findByHabitacionId(int habitacionId) {
        List<Resena> resenas = new ArrayList<>();
        for (Document doc : collection.find(Filters.eq("habitacionId", habitacionId))) {
            resenas.add(documentToResena(doc));
        }
        return resenas;
    }

    public boolean delete(String id) {
        if (id == null || id.isEmpty()) {
            return false;
        }

        try {
            ObjectId objectId = new ObjectId(id);
            return collection.deleteOne(Filters.eq("_id", objectId)).getDeletedCount() > 0;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
