package ViewModel;

import ViewModel.Spaces.FinancialSpace;

public class Constants {
    public static final byte NONE = -125;
    public static final FinancialSpace AREA_PERSONAL= new FinancialSpace();

    public static final int AREA_PERSONAL_ID = 0x0;
    // asset-pasive types
    public static final byte NO_CURRENT = 0;
    public static final byte CURRENT = 1;
    // periodicy
    public static final byte DAILY = 2;
    public static final byte WEEKLY = 3;
    public static final byte MONTHLY = 4;
    public static final byte YEARLY = 5;
    //interest types
    public static final byte LINEAL_INTEREST = 6;
    public static final byte COMPOUND_INTEREST = 7;
    //form types
    public static final byte RENEUE_FORM_TYPE = 8;
    public static final byte EXPENSE_FORM_TYPE = 9;
    public static final String DEFAULT_GROUP = "";

    public static final float MAX_BRUTE_WORTH = 163386000;
    public static final float MAX_BRUTE_REVENUES = 50831000;
    public static final float MAX_CREDIT_CARD_EXPENSES = 50831000;
    public static final float MAX_EXPENSES = 50831000;
    public static final float MAX_TRANSACTIONS_EXPENSES = 50831000;
    public static final float MAX_IVA_EXPENSES = 14000000;
    public static final float MAX_IVA_REVUNES = 14000000;


    public static final String[] ProductosSinIVA={
            "Arroz", "Pan", "OtrosProductosPanaderia", "Papa", "Yuca", "OtrosTuberculos", "Platano", "Cebolla", "Tomate", "Zanahoria", "RevueltoVerde", "OtrasOrtalizasyLegumbresFrescas",
            "Frijol", "Arveja", "OtrasHortalizasYLegumbresSecas", "Naranjas","Bananos", "TomateArbol", "Moras", "OtrosFrutosSecos", "Res", "Cerdo", "Pollo", "Huevos", "Leche", "Queso", "Panela",
            "Sal", "Agua", "Almuerzo", "Hamburguesa", "ComidasRapidasCalientes", "GastosDeCafeteria", "ComidasRapidasFrias", "ArrendamientoEfectivo", "ArrendamientoImputado", "OtrosGastosOcupacion",
            "Gas", "EnergiaELectrica", "Acueducto", "Alcantarillado", "Aseo", "Insecticidas", "ConsultaMedicoGeneral", "MedicinaEspecializada", "ExamenesDeLaboratorio", "ImagenesDiagnosticas",
            "ServiciosDeHospitalizacionYAmbulancias", "Medicinas", "OtrasMedicinasYAnticonceptivos","AparatosOrtopedicos", "Matriculas", "Pensiones", "OtrosCostosEducativos", "Textos", "Cuadernos",
            "Revistas", "Libros", "Periodicos", "ServiciosRelacionadosConDiversion", "ServiciosCulturales", "Bus", "Buseta", "Taxi", "OtrosMediosParaTransporteUrbano", "BusIntermunicipal",
            "OtrosTransporteIntermunicipal", "PorteDeCartas", "Aguardiente", "OtrasBebidasAlcoholicas", "HigieneOral", "ServiciosBancarios", "SegurosDeVehiculo"

        };
    public static final String[] ProductosConIVA={
            "HarinaDeMaiz", "PastasAlimenticias", "CerealesPreparados", "OtrosCereales", "HortalizasYLegumbresEnlatadas", "FrutasEnConserva", "FrutasSecas", "CarnesFrias", "OtrosProductosDeMar",
            "OtrosDerivadosLacteos", "Aceites", "Grasas", "Azucar", "Cafe", "Chocolate", "OtrosCondimentos", "SopasYCremas", "Salsas", "Aderezos", "Dulces", "Confites", "Gelatina", "OtrosAbarrotes",
            "Sala", "Comedor", "Alcoba", "EquiposDeIluminacion", "Nevera", "Estufa", "Lavadora", "OtrosAparatosHogar", "ReparacionDeArtefactosParaElHogar", "Ollas", "Sartenes", "Refractarias",
            "OtrosUtensilios", "Vajilla", "Cubiertos", "OtrosUtensiliosDomesticos", "JuegoDeSabanasYFundas", "CobijasYCubrelechos", "ColchonesYAlmohadas", "Cortinas", "Toallas", "Manteles", "ForrosParaMuebles",
            "Jabones", "Detergentes", "Blanqueadores", "Suavizantes", "Limpiadores", "Desinfectantes", "Ceras", "PapelesDeCocina", "OtrosUtensiliosDeAseo", "CamisasHombre", "PantalonesHombre", "RopaInteriorHombre",
            "OtrasPrendaVestirHombre", "Blusa", "PantalonesMujer", "RopaInteriorMujer", "OtrasPrendasVestirMujer", "CamisasNiño", "BlusasNiña", "PantalonesNiño", "OtrasPrendasVestirNiño", "RopaInteriorNiños",
            "CamisetasBebes", "VestidosBebe", "Pañales", "CalzadoHombre", "CalzadoMujer", "CalzadoDeportivo", "CalzafoNiños", "ConfeccionYAlquiler", "Lavanderia", "ReparacionYLimpieza", "AseguramientoPrivadp",
            "ServiciosDeProteccion", "PagosComplementarios", "OtrosArticulosEscolares", "OtrosGastosEscolares", "Juegos", "Aficiones", "Articulos", "Adornos", "PrendasVestirFiesta", "JardinesYProductosAnimalesDomesticos",
            "Discos", "ArticulosDeportivos","Televisor","OtrosAparatosDeVideoeImagen", "EquipoDeSonido", "Computadoras", "Impresoras", "OtrosAparatos", "ServiciosDeTv", "Turismo", "JuegosAzar", "ServicioParaMascotas",
            "Vehiculos", "OtrosParaTransporte", "Combustible", "CompraYCambioAceite", "ServicioParqueadero", "ServiciosMecanica", "Bateria", "Llantas", "PasajeAereo", "ServicioDeTelefonia", "OtrosServiciosDeTelefonia",
            "EquiposTelefoniaMovilYSimilares", "Cerveza", "Cigarrilos", "HigieneCorporal", "HigieneYCuidadoFacial", "CuidadoDelCabello", "OtrosProductosRelacionadosConHigienePersonal", "CorteCabello", "OtrosServiciosRelacionadosParaElCuidadoPersonal",
            "JoyeriaEnOro", "JoyeriaEnPlata", "Relojes", "OtrosArticulosPersonales", "OtrosServiciosFinancieros"

    };

}
