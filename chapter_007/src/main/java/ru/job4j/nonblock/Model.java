package ru.job4j.nonblock;

/**
 * class Model.
 */
public class Model {
    /** id.*/
    private Integer id;
    /** name.*/
    private String name;
    /** version.*/
    private int version;

    /**
     * constructor.
     * @param name - name.
     * @param id - id.
     */
    public Model(String name, Integer id) {
        this.name = name;
        this.id = id;
        this.version = 1;
    }

    /**
     * method getName.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * method getVersion.
     * @return version.
     */
    public int getVersion() {
        return version;
    }

    /**
     * method setName.
     * @param name - new name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method upDateVersion.
     */
    public void upDateVersion() {
        this.version++;
    }

    /**
     * method getId.
     * @return id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * method toString.
     * @return string.
     */
    @Override
    public String toString() {
        return "id " + id + " " + name + " version " + version;
    }
}
