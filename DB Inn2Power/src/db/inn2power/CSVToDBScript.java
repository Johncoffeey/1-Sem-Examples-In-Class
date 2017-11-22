/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.inn2power;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import db.inn2power.be.Company;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author pgn
 */
public class CSVToDBScript
{

    public static String SERVER_NAME = "EASV-DB2";
    public static String DATABASE_NAME = "YOUR DATABASE NAME HERE";
    public static String USER = "YOUR USER HERE";
    public static String PASSWORD = "YOUR PASSWORD HERE";
    public static int PORT_NUMBER = 1433;

    public static void main(String[] args) throws IOException, SQLException
    {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setServerName(SERVER_NAME);
        dataSource.setDatabaseName(DATABASE_NAME);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setPortNumber(PORT_NUMBER);

        File csvCompanies = new File("companies.csv");

        List<Company> companies = new ArrayList<>();

        Random rnd = new Random(666);

        for (String line : Files.readAllLines(csvCompanies.toPath(), StandardCharsets.ISO_8859_1))
        {
            try
            {
                String[] splitLine = line.split(",");
                int id = Integer.parseInt(splitLine[0]);
                String name = splitLine[1];
                String country = splitLine[2];
                String address = splitLine[3];
                String website = splitLine[4];
                String supplyChainCategoriy = SUPPLY_CHAIN_CATEGORIES[rnd.nextInt(SUPPLY_CHAIN_CATEGORIES.length)];
                String buisnessRole = BUISNESS_ROLES[rnd.nextInt(BUISNESS_ROLES.length)];
                double lat = Double.parseDouble(splitLine[5]);
                double lng = Double.parseDouble(splitLine[6]);
                int isSME = Integer.parseInt(splitLine[7]);

                Company c = new Company(id, name, country, address, website, supplyChainCategoriy, buisnessRole, lat, lng, isSME);
                companies.add(c);
            } catch (NumberFormatException nfe)
            {
                System.out.println("Exception: " + nfe.getMessage());
            }
        }

        List<Integer> ids = new ArrayList<>();

        for (Company company : companies)
        {
            try (Connection con = dataSource.getConnection())
            {
                String sql = "INSERT INTO Company VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

                PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                statement.setString(1, company.getName());
                statement.setString(2, company.getCountry());
                statement.setString(3, company.getAddress());
                statement.setString(4, company.getWebsite());
                statement.setString(5, company.getSupplyChainCategoriy());
                statement.setString(6, company.getBuisnessRole());
                statement.setDouble(7, company.getLat());
                statement.setDouble(8, company.getLng());
                statement.setInt(9, company.getIsSME());

                if (statement.executeUpdate() == 1)
                {
                    //Good
                    ResultSet rs = statement.getGeneratedKeys();
                    rs.next();
                    int id = rs.getInt(1);
                    ids.add(id);
                }
            }
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("relations.csv")))))
        {
            String line = br.readLine();
            while (line != null)
            {
                try
                {
                    String[] p = line.split(",");// a CSV has comma separated lines
                    if (p.length != 4)
                    {
                        continue;
                    }
                    String type = p[2];
                    String strength = p[3];
                    int id = ids.get(rnd.nextInt(ids.size()));
                    int id2 = ids.get(rnd.nextInt(ids.size()));
                    while (id2 == id)
                    {
                        id2 = ids.get(rnd.nextInt(ids.size()));
                    }

                    try (Connection con = dataSource.getConnection())
                    {
                        String sql = "INSERT INTO Relation VALUES (?, ?, ?, ?);";
                        PreparedStatement statement = con.prepareStatement(sql);
                        statement.setInt(1, id);
                        statement.setInt(2, id2);
                        statement.setString(3, type);
                        statement.setString(4, strength);
                        statement.execute();
                    }
                } catch (Exception iae)
                {
                    //Do nothing, move on
                }
                line = br.readLine();
            }
        }

    }

    public static final String[] SUPPLY_CHAIN_CATEGORIES =
    {
        "& Commissioning",
        "Academic Institution",
        "Access Systems",
        "Accommodation Modules",
        "Accountancy, Financial, Insurance & Tax",
        "Anchoring & Moorings",
        "Anchoring&Moorings",
        "Anchors & Moorings",
        "Applied Research",
        "Architectural / Building Materials",
        "Assembly & Installation",
        "Assembly Installation",
        "Assembly&Installation",
        "Bearings",
        "Blade",
        "Boilers",
        "Bolting",
        "Bolting, Fixing & Fasteners",
        "Bolting, Fixing or Fasteners",
        "Bolting, Fixing or Fasteners, Cables & Connectors",
        "Bolting,Fixing & Fasteners",
        "Bolting´s, Fixing & Fasteners",
        "Bolting's, Fixing & Fasteners",
        "Bolting's, Fixings & Fasteners",
        "Brakes",
        "Buoys & Buoyancy",
        "Buoys & Buoyancy Materials",
        "Buoys&Buoyancy",
        "Business Development",
        "Cable Lay Vessels",
        "Cables & Connectors",
        "Cables and connectors",
        "Cables laying",
        "Cables&Connectors",
        "Cases & Packaging",
        "Certification",
        "Certification & Due Dilligence (planning phase)",
        "Certification, Construction Vessels, Cranes (Fixed), Fabrication & Construction, Feasibility / Front End Design Studies",
        "Chemicals, Oils & Paints",
        "Cluster Management",
        "CO2 Process Equipment",
        "CO2 Process Equipment, Decommissiong&Abandonment",
        "CO2 Process Equipment, Hoses&Fittings",
        "Communication Systems",
        "Compnents Replacement",
        "Component Replacement",
        "Component Supply",
        "Components supply",
        "Components Supply",
        "Composite",
        "Compressors",
        "Compressors, Control Systems",
        "Computing & Information",
        "Computing & Information Technology",
        "Computing &Information Technology",
        "Computing and Information Technology",
        "Computing&Information Technology",
        "Connectors",
        "Construction",
        "Construction Vessel",
        "Construction Vessels",
        "Control system and remote monitoring",
        "Control Systems",
        "Control Systems & Remote Monitoring",
        "Cooling",
        "Cooling, Heating, Ventilation & Air Conditioning",
        "Corrosion Protection",
        "Corrosion Protection, Decommissioning & Abandonment",
        "Cranes (fixed)",
        "Cranes (Fixed)",
        "Cranes (mobile)",
        "Cranes (Mobile)",
        "Crew Boat",
        "Crew Transfer Vessel",
        "Crew Transfer Vessels",
        "Decommissioning & Abandonment",
        "Decommissioning & Recommissioning",
        "Decommissioning&Recommissioning",
        "Design & Engineering",
        "Design & Engineering g",
        "Design Development & Financing",
        "Design, Development & financing",
        "DesignDevelopment & Financing",
        "Developer",
        "Develops, buils&operates wind farms",
        "Diving & Underwater Services",
        "Diving & Underwater Services, Environmental Assessment & Monitoring",
        "Diving&Underwater Services",
        "Diving&Underwater Services, Drilling&Wells Services, Fabrication & Construction, Hoses&Fittings, Machine Shops, Metal Materials, Process Equipment",
        "Drilling & Wells Services",
        "Drilling&Wells Services",
        "Drones/ROVs",
        "Dynamic Positioning Cessels",
        "Dynamic Positioning Systems",
        "Dynamic Positioning Vessels",
        "Electrical contractor",
        "Electrical Equipment",
        "Electrical Equipment, Materials & Services",
        "Electrical Equipment, Materials&Services",
        "Electrical Equipment_ Materials & Services",
        "Electrical Equipment_ Materials&Services",
        "Electronics",
        "Eletrical Equipment Materials & Services",
        "Energy Company",
        "Engines",
        "Engines, Fabrication & Construction",
        "Environment Assessment&Monitoring",
        "Environmental Assessment & Monitoring",
        "Environmental Assessment&Monitoring",
        "Environmental consultancy",
        "Envitomental Assessment&Monitoring",
        "Equipment, Tooling & Consumables",
        "Equipment, Tooling Consumables",
        "Exploration&Production",
        "Fabrication & Construction",
        "Fabrication&Construction",
        "Fabrications & Construction",
        "Feasbility / Front End Design Studies",
        "Feasibility / Front End Design Studies",
        "Feasibility / Front End Studies",
        "Feasibility/Front End Design Studies",
        "Fixing & Fasteners",
        "Fixing or Fasteners",
        "Fixing&Fasteners",
        "Fluids &Lubricants, Gears&Gearboxes",
        "Fluids&Lubricants",
        "Forging & Casting",
        "Forging&Casting",
        "Foundations & Piles",
        "Foundations&Piles",
        "Freight",
        "Freight, Logistics & Transportation",
        "Furnaces",
        "Gas company supplier",
        "Gas Turbine",
        "Gas Turbines",
        "Gears & Gearboxes",
        "Gears&Gear Boxes",
        "Gears&Gearboxes",
        "Generators",
        "Geoservices",
        "Grid Interface",
        "Grid Interface / Substations",
        "Grid Interface or Substations",
        "Groting",
        "Grouting",
        "Grouting, Scour Protection",
        "Haxardous Area Equipment & Services",
        "Hazardous Area Equipment & Services",
        "Heat Exchangers",
        "Heaters",
        "Heaters, Heat Exchangers, Furnaces, Boilers etc.",
        "Heaters_ Heat Exchangers_ Furnaces_ Boilers etc.",
        "Heating, Ventilation & Air Conditioning",
        "Helicopter Support",
        "Hoses & Fitting",
        "Hoses & Fittings",
        "Hoses&Fittings",
        "Hydraulics & Pneumatics",
        "Hydraulics&Pneumatics",
        "Inspection & Testing",
        "Inspection & Testing, Process Control, Process Equipment, Pumps&Accessories, Surface Treatment",
        "Inspection&Testing",
        "Installatiion & Commissioning",
        "Installation & Commissioning",
        "Installation&Commissioning",
        "Installations & Commissioning",
        "Instrumentation",
        "Instrumentation, Metal Materials",
        "Instrumentation, Metal Materials, Process Control",
        "Instrumentation, Pumps&Accessories",
        "Insulation",
        "Integrated Services",
        "International Trade",
        "Jack-ups",
        "Land & Premises",
        "Legal services",
        "Legal Services",
        "Legislation & Regulations",
        "Legislation&Registration",
        "Lifting equipment",
        "Lifting Equipment",
        "Local Authority",
        "Logistics & Transportation",
        "Machine Shops",
        "Machining Shops",
        "Maintenance",
        "Maintenance, Modification & Operation",
        "Maintenance_ Modification&Operation",
        "Manufacture/supply",
        "Market Research",
        "Marketing",
        "Material & Product Handling",
        "Material & Product Handling  & Product Handling",
        "Material & Product Handling s&Services",
        "Material and Product Handling",
        "Material&product Handling",
        "Material&Product Handling",
        "Materials",
        "Materials & Services",
        "Media",
        "Medical",
        "Metal Material",
        "Metal materials",
        "Metal Materials",
        "Meterological Services",
        "Modification & Operation",
        "Modification&Operation",
        "Nacelles",
        "Navigation Aids",
        "Networking & Events",
        "Networking&Events",
        "Non - Metallic Materials",
        "Non-Metal Material",
        "Non-Metalic Materials",
        "Oils & Paints",
        "Operation & Maintenance",
        "Operationa & Maintenance",
        "Operations & Maintenance",
        "Operations& Maintenance",
        "Operations&Maintenance",
        "Operator",
        "or Front End Studies",
        "or Front End Studies, Inspection & Testing",
        "or Front End Studies, Material&Product Handling, Process Equipment, Project Management",
        "Other",
        "Other Equipment",
        "Patent",
        "Patent, Trademark & Copyright",
        "Personnel",
        "Pipelines & Risers",
        "Pipelines&Risers",
        "Pipes",
        "Pipes, Pipelines & Risers",
        "Pipes, Pipelines&Risers",
        "Pipes_ Pipelines & Risers",
        "Planning & EIA",
        "Plastics",
        "Ports & Supply Bases",
        "PPE & Safety equipment",
        "Process Control",
        "Process Equipment",
        "Project Management",
        "Project Management, Security, Water Treatment, Environment Assessment&Monitoring",
        "Project Management, Seismic, Cases & Packaging, Compressors, Drilling&Wells Services",
        "Propulsion Systems",
        "Publications & Technical Manuals",
        "Pumps & Accessories",
        "Pumps&Accessories",
        "Researc & Development",
        "Research & Development",
        "Reservoir Engineering",
        "Ropes",
        "Ropes, Rotor Blades",
        "Rotor Blades",
        "ROVs",
        "Safety",
        "Scour Protection",
        "Seabed Surveying & Positioning",
        "Seals & Gaskets",
        "Seals&Gaskets",
        "Security",
        "Seismic",
        "Service",
        "Service  & Support Vessels",
        "Service & Support Vessel",
        "Service & Support vessels",
        "Service & Support Vessels",
        "Service and Support Vessels",
        "Service Contracting",
        "Service Provider",
        "Signs",
        "Signs, Supply Chain Management",
        "Software Development",
        "Specialist vessel & Associated Equipment",
        "Specialist Vessels /Vehicle",
        "Specialist vessels/vehicle",
        "Specialist Vessels/Vehicle",
        "Steel contractor",
        "Subsea Production & Control",
        "Subsea Production&Control",
        "Substations",
        "Supply Chain Management",
        "Supply Chain Management,Topside or Deck Structures",
        "Support Organisation",
        "Support service",
        "Support Service",
        "Support Service (Commercial)",
        "Support services",
        "Support Services",
        "Support services (Commercial)",
        "Support Services (Operational)",
        "Support Vessels",
        "Surface Treatment",
        "Surfarce Treatment",
        "Survey  &  Positioning",
        "Survey & Positioning",
        "Survey vessel",
        "Survival Offshore",
        "Teaching",
        "Technology",
        "Technology Services",
        "Tooling",
        "Tooling&Consumables",
        "Topside / Deck Structures",
        "Topside or Deck Structures",
        "Topside or Deck Structures, Towers, Waste Management",
        "TopsideorDeck Structures",
        "Towers",
        "Trade Association",
        "Training",
        "Training & Education",
        "Transmission System Operator",
        "Umbilicals",
        "Utility energy provider",
        "Valves & Accessories",
        "Valves&Accessories",
        "Vessel operator",
        "Vessels",
        "Vocational Education",
        "Waste Management",
        "Water Treatment",
        "Weather Service",
        "Welding",
        "Welding, Wellheads&Xmas Trees",
        "Welding, Workshop & Hand Tools",
        "Welding, Workshop&Hand Tools",
        "Wellheads&Xmas Trees",
        "Wellheads&Xmas Trees, Workshop&Hand Tools",
        "Wind farm owner",
        "Wind turbine",
        "Wind Turbine",
        "Workshop & Hand Tools",
        "Workshop&Hand Tools",
        "Workwear"
    };

    public static final String[] BUISNESS_ROLES =
    {
        "Consultant",
        "Design & Engineering",
        "Installation",
        "Manufacture / Supply",
        "Operator",
        "Research & Development",
        "Service Provider",
        "Support Organisation",
        "Test & Demonstration",
        "Training & Education"
    };

}
