package br.com.alura.screenmatch.model;

public enum Categoria {
    ACAO("Action"),
    AVENTURA("Adventure"),
    ANIMACAO("Animation"),
    COMEDIA("Comedy"),
    CRIME("Crime"),
    DOCUMENTARIO("Documentary"),
    DRAMA("Drama"),
    FANTASIA("Fantasy"),
    FICCAO_CIENTIFICA("Sci-Fi"),
    TERROR("Horror"),
    ROMANCE("Romance"),
    SUSPENSE("Thriller"),
    MUSICAL("Musical"),
    GUERRA("War"),
    MISTERIO("Mystery"),
    FAROESTE("Western");

    private final String categoriaOmdb;

    Categoria(String categoriaOmdb) {
        this.categoriaOmdb = categoriaOmdb;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}