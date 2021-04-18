package fr.uvsq.poo.Builder_Composite_Iterator;

import java.io.Serializable;

public abstract class DAOSerialiser <T extends Serializable>	extends SerialiserClass<T>  implements InterfaceDAO<T>{

    private Logger log = new Logger();
    public abstract String getFilename(String id);
    public abstract String getFilename(T objet);
    @Override
    public T create(T objet) {
        return createFile(objet, getFilename(objet), log);
    }

    @Override
    public T read(String id) {
        return readFile(getFilename(id), log);
    }

    @Override
    public T update(T objet) {
        return updateFile(objet, getFilename(objet), log);
    }

    @Override
    public void delete(T objet) {
        deleteFile(getFilename(objet), log);
    }
}
