-- Table: public.bodega

-- DROP TABLE public.bodega;

CREATE TABLE public.bodega
(
    idbodega character varying(50) COLLATE pg_catalog."default" NOT NULL,
    nombrebodega character varying(50) COLLATE pg_catalog."default",
    direccion character varying(80) COLLATE pg_catalog."default",
    ciudad character varying(20) COLLATE pg_catalog."default",
    departamento character varying(30) COLLATE pg_catalog."default",
    pais character varying(50) COLLATE pg_catalog."default",
    fechacreacion timestamp without time zone,
    fechamodificacion timestamp without time zone,
    CONSTRAINT pk_bodega PRIMARY KEY (idbodega),
    CONSTRAINT uq_bodega_idbodega UNIQUE (idbodega)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.bodega
    OWNER to postgres;
	
-- Table: public.inventario_bodega

-- DROP TABLE public.inventario_bodega;

CREATE TABLE public.inventario_bodega
(
    idproductobodega character varying(50) COLLATE pg_catalog."default" NOT NULL,
    idproducto character varying(50) COLLATE pg_catalog."default",
    idbodega character varying(50) COLLATE pg_catalog."default",
    cantproductosent numeric(10,0),
    cantproductossal numeric(10,0),
    fechacreacion timestamp without time zone,
    fechamodificacion timestamp without time zone,
    CONSTRAINT pk_producto_bodega PRIMARY KEY (idproductobodega),
    CONSTRAINT uq_producto_bodega_idproductobodega UNIQUE (idproductobodega),
    CONSTRAINT fk_producto_bodega_bodega FOREIGN KEY (idbodega)
        REFERENCES public.bodega (idbodega) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_producto_bodega_producto FOREIGN KEY (idproducto)
        REFERENCES public.producto (idproducto) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.inventario_bodega
    OWNER to postgres;
	
-- Table: public.inventario_puntoventa

-- DROP TABLE public.inventario_puntoventa;

CREATE TABLE public.inventario_puntoventa
(
    idinventariopuntoventa character varying(50) COLLATE pg_catalog."default" NOT NULL,
    idproducto character varying(50) COLLATE pg_catalog."default",
    idpuntosventa character varying(50) COLLATE pg_catalog."default",
    cantproductoent numeric(10,0),
    cantproductosal numeric(10,0),
    fechacreacion timestamp without time zone,
    fechamodificacion timestamp without time zone,
    CONSTRAINT pk_inventario_puntoventa PRIMARY KEY (idinventariopuntoventa),
    CONSTRAINT uq_inventario_puntoventa_idinventariopuntoventa UNIQUE (idinventariopuntoventa),
    CONSTRAINT fk_inventario_puntoventa_producto FOREIGN KEY (idproducto)
        REFERENCES public.producto (idproducto) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_inventario_puntoventa_puntoventa FOREIGN KEY (idpuntosventa)
        REFERENCES public.puntoventa (idpuntosventa) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.inventario_puntoventa
    OWNER to postgres;
	
-- Table: public.producto

-- DROP TABLE public.producto;

CREATE TABLE public.producto
(
    idproducto character varying(50) COLLATE pg_catalog."default" NOT NULL,
    nombreproducto character varying(80) COLLATE pg_catalog."default",
    preciounidad numeric(10,2),
    valormayor numeric(10,2),
    fechacreacion timestamp without time zone,
    fechamodificacion timestamp without time zone,
    idproveedor character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT pk_producto PRIMARY KEY (idproducto),
    CONSTRAINT uq_producto_idproducto UNIQUE (idproducto),
    CONSTRAINT uq_producto_nombreproducto UNIQUE (nombreproducto),
    CONSTRAINT fk_producto_proveedor FOREIGN KEY (idproveedor)
        REFERENCES public.proveedor (idproveedor) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.producto
    OWNER to postgres;
	
-- Table: public.proveedor

-- DROP TABLE public.proveedor;

CREATE TABLE public.proveedor
(
    idproveedor character varying(50) COLLATE pg_catalog."default" NOT NULL,
    razonsocial character varying(50) COLLATE pg_catalog."default",
    direccion character varying(50) COLLATE pg_catalog."default",
    telefono numeric(10,0),
    snactivo boolean,
    fechadesvinculacion timestamp without time zone,
    fechamodificacion timestamp without time zone,
    fechacreacion timestamp without time zone,
    CONSTRAINT pk_proveedor PRIMARY KEY (idproveedor),
    CONSTRAINT uq_proveedor_idproveedor UNIQUE (idproveedor)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.proveedor
    OWNER to postgres;
	
-- Table: public.puntoventa

-- DROP TABLE public.puntoventa;

CREATE TABLE public.puntoventa
(
    idpuntosventa character varying(50) COLLATE pg_catalog."default" NOT NULL,
    razonsocial character varying(50) COLLATE pg_catalog."default",
    direccion character varying(50) COLLATE pg_catalog."default",
    ciudad character varying(20) COLLATE pg_catalog."default",
    departamento character varying(20) COLLATE pg_catalog."default",
    pais character varying(20) COLLATE pg_catalog."default",
    telefono numeric(10,0),
    fechacreacion timestamp without time zone,
    fechamodificacion timestamp without time zone,
    CONSTRAINT pk_puntosventa PRIMARY KEY (idpuntosventa),
    CONSTRAINT uq_puntosventa_idpuntosventa UNIQUE (idpuntosventa),
    CONSTRAINT uq_puntosventa_razonsocial UNIQUE (razonsocial)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.puntoventa
    OWNER to postgres;