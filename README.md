QUERRY PARA MYSQL:
Part - 1

INSERT INTO fabricantes (nome, pais_origem)
VALUES 
    ('Volkswagen', 'Alemanha'),
    ('Fiat', 'Itália'),
    ('Chevrolet', 'Estados Unidos'),
    ('Toyota', 'Japão'),
    ('Hyundai', 'Coreia do Sul'),
    ('Honda', 'Japão'),
    ('Ford', 'Estados Unidos'),
    ('Renault', 'França'),
    ('Nissan', 'Japão'),
    ('Jeep', 'Estados Unidos');
    
Part -2

INSERT INTO modelos (nome, fk_id_fabricante)
VALUES 
    -- Modelos da Volkswagen
    ('Gol', 1),
    ('Polo', 1),

    -- Modelos da Fiat
    ('Uno', 2),
    ('Toro', 2),

    -- Modelos da Chevrolet
    ('Onix', 3),
    ('S10', 3),

    -- Modelos da Toyota
    ('Corolla', 4),
    ('Hilux', 4),

    -- Modelos da Hyundai
    ('HB20', 5),
    ('Creta', 5),

    -- Modelos da Honda
    ('Civic', 6),
    ('HR-V', 6),

    -- Modelos da Ford
    ('Ka', 7),
    ('Ranger', 7),

    -- Modelos da Renault
    ('Kwid', 8),
    ('Duster', 8),

    -- Modelos da Nissan
    ('March', 9),
    ('Kicks', 9),

    -- Modelos da Jeep
    ('Renegade', 10),
    ('Compass', 10);
    
