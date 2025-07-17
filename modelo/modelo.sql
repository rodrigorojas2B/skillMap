
-- Tabla de categorías de skills
CREATE TABLE categoria (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL
);

-- Tabla de skills, asociadas a categoría
CREATE TABLE skill (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    categoria_id INT REFERENCES categoria(id)
);

-- Contenido asociado a skills, diseñado para un nivel específico (1 a 5)
CREATE TABLE contenido (
    id SERIAL PRIMARY KEY,
    nivel INT CHECK (nivel BETWEEN 1 AND 5),
    url_curso TEXT,
    url_test TEXT,
    skill_id INT REFERENCES skill(id)
);

-- Especialidades técnicas
CREATE TABLE especialidad (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- Roles técnicos (ej. Dev Backend), asociados a una especialidad
CREATE TABLE rol (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR(100),
    especialidad_id INT REFERENCES especialidad(id),
    grado VARCHAR(20) CHECK (grado IN ('Trainee','Junior','Pleno','Semi-Senior','Senior','Experto'))
);

-- Nivel esperado por skill en función del rol y grado
CREATE TABLE skill_map (
    id SERIAL PRIMARY KEY,
    rol_id INT REFERENCES rol(id),
    skill_id INT REFERENCES skill(id),
    grado VARCHAR(20) CHECK (grado IN ('Trainee','Junior','Pleno','Semi-Senior','Senior','Experto')),
    nivel_base INT CHECK (nivel_base BETWEEN 1 AND 5),
    UNIQUE (rol_id, skill_id, grado)
);

-- Información de colaboradores
CREATE TABLE colaborador (
    id VARCHAR(20) PRIMARY KEY, -- Puede ser RUT, DNI, etc.
    nombre VARCHAR(30) NOT NULL,
    paterno VARCHAR(30),
    materno VARCHAR(30),
    vigente BOOLEAN DEFAULT TRUE,
    id_calibrador_actual VARCHAR(20) REFERENCES colaborador(id)
);

-- Evaluación de un colaborador en una fecha determinada
CREATE TABLE skill_fit (
    id SERIAL PRIMARY KEY,
    fecha_autoeval DATE,
    fecha_calibracion DATE,
    descripcion VARCHAR(100),
    id_colaborador VARCHAR(20) REFERENCES colaborador(id),
    id_calibrador VARCHAR(20) REFERENCES colaborador(id)
);

-- Evaluación individual por skill dentro de una sesión (fit)
CREATE TABLE skill_eval (
    id SERIAL PRIMARY KEY,
    nivel_autoeval INT CHECK (nivel_autoeval BETWEEN 1 AND 5),
    nivel_calibrado INT CHECK (nivel_calibrado BETWEEN 1 AND 5),
    observaciones VARCHAR(100),
    nota_test NUMERIC(5,2),
    url_evidencia TEXT,
    id_skill_fit INT REFERENCES skill_fit(id),
    id_skill INT REFERENCES skill(id)
);
