CREATE TABLE IF NOT EXISTS livros (
                                      id_livro   BIGSERIAL PRIMARY KEY,
                                      nome_livro VARCHAR(255) NOT NULL,
    paginas    INTEGER NOT NULL CHECK (paginas > 0),
    autor      VARCHAR(255) NOT NULL,
    categoria  VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
    );
