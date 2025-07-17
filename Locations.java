import java.util.ArrayList;
import java.util.HashMap;

public class Locations {
    private static HashMap<String, Location> locations = new HashMap<>();

    public static void fillList() {
        // Entrance location
        Location entrance = new Location("Eingang", "A dense forest with towering trees.", "images/entrance.jpeg");
        ArrayList<Pointer> pointersEntrance = new ArrayList<>();
        pointersEntrance.add(new Pointer(1, -20, "lobby").setRotation(0));
        entrance.setPointers(pointersEntrance);
        locations.put("entrance", entrance);

        // Location lobby
        Location lobby = new Location("Lobby", "A spacious lobby with a grand chandelier.", "images/lobby.jpg");
        ArrayList<Pointer> pointersLobby = new ArrayList<>();
        pointersLobby.add((new Pointer(40, -20, "enter_main_building")).setRotation(-45)); // To enter main building
        pointersLobby.add(new Pointer(0, -30, "entrance").setRotation(180)); // Back to entrance
        lobby.setPointers(pointersLobby);
        locations.put("lobby", lobby);

        // Location "enter main building" (door)
        Location enterMainBuilding = new Location("Hauptgebäude",
                "You are at the main building's entrance. The door is open and you can enter",
                "images/enter_main_building.jpeg");
        ArrayList<Pointer> pointersEnterMainBuilding = new ArrayList<>();
        pointersEnterMainBuilding.add(new Pointer(-40, -15, "hallway_physics").setRotation(45)); // To physics hallway
        pointersEnterMainBuilding.add(new Pointer(15, -5, "hallway_biology_chemistry").setRotation(-90)); // To biology/chemistry hallway
        pointersEnterMainBuilding.add(new Pointer(0, -30, "lobby").setRotation(180)); // Back to lobby
        enterMainBuilding.setPointers(pointersEnterMainBuilding);
        locations.put("enter_main_building", enterMainBuilding);

        // Location "hallway biology chemistry"
        Location hallwayBioChem = new Location("Flur Biologie Chemie",
                "You are in the hallway between the biology and chemistry classrooms.",
                "images/hallway_biology_chemistry.jpeg");
        ArrayList<Pointer> pointersHallwayBioChem = new ArrayList<>();
        pointersHallwayBioChem.add(new Pointer(-5, 0, "biology_door").setRotation(0)); // To biology classroom
        pointersHallwayBioChem.add(new Pointer(15, 5, "chemistry_door").setRotation(-90)); // To chemistry classroom
        pointersHallwayBioChem.add(new Pointer(0, -30, "enter_main_building").setRotation(180)); // Back to main building entrance
        hallwayBioChem.setPointers(pointersHallwayBioChem);
        locations.put("hallway_biology_chemistry", hallwayBioChem);

        // Location chemistry classroom door
        Location chemistryClassroomDoor = new Location("Chemie Klassenzimmer Tür",
                "You are at the door of the chemistry classroom. The door is unlocked.",
                "images/door_chemistry.jpeg");
        ArrayList<Pointer> pointersChemistryDoor = new ArrayList<>();
        pointersChemistryDoor.add(new Pointer(0, -30, "hallway_biology_chemistry").setRotation(180)); // Back to hallway
        pointersChemistryDoor.add(new Pointer(0, -20, "chemistry_inside").setRotation(0)); // Enter chemistry classroom
        chemistryClassroomDoor.setPointers(pointersChemistryDoor);
        locations.put("chemistry_door", chemistryClassroomDoor);

        // Location chemistry classroom inside
        Location chemistryClassroomInside = new Location("Chemie Klassenzimmer",
                "You are inside the chemistry classroom. The room is filled with lab equipment.",
                "images/chemistry_classroom.jpeg");
        ArrayList<Pointer> pointersChemistryInside = new ArrayList<>();
        pointersChemistryInside.add(new Pointer(0, 30, "chemistry_door").setRotation(180)); // Back to chemistry classroom door
        pointersChemistryInside.add(new Pointer(0, 20, "biology_door").setRotation(90)); // To biology classroom
        chemistryClassroomInside.setPointers(pointersChemistryInside);
        locations.put("chemistry_inside", chemistryClassroomInside);

        // Location biology classroom door
        Location biologyClassroomDoor = new Location("Biologie Klassenzimmer Tür",
                "You are at the door of the biology classroom. The door is unlocked.",
                "images/door_biology.jpeg");
        ArrayList<Pointer> pointersBiologyDoor = new ArrayList<>();
        pointersBiologyDoor.add(new Pointer(0, -30, "hallway_biology_chemistry").setRotation(180)); // Back to hallway
        pointersBiologyDoor.add(new Pointer(0, -20, "biology_inside").setRotation(0)); // Enter biology classroom
        biologyClassroomDoor.setPointers(pointersBiologyDoor);
        locations.put("biology_door", biologyClassroomDoor);

        // Location biology classroom inside
        Location biologyClassroomInside = new Location("Biologie Klassenzimmer",
                "You are inside the biology classroom. The room is filled with plants and equipment.",
                "images/biology_classroom.jpeg");
        ArrayList<Pointer> pointersBiologyInside = new ArrayList<>();
        pointersBiologyInside.add(new Pointer(0, 30, "biology_door").setRotation(180)); // Back to biology classroom door
        biologyClassroomInside.setPointers(pointersBiologyInside);
        locations.put("biology_inside", biologyClassroomInside);

        // Location "hallway physics"
        Location hallwayPhysics = new Location("Flur Physik",
                "You are in the hallway leading to the physics classroom.",
                "images/hallway_physics.jpeg");
        ArrayList<Pointer> pointersHallwayPhysics = new ArrayList<>();
        pointersHallwayPhysics.add(new Pointer(-10, -10, "physics_door").setRotation(0)); // To physics classroom
        pointersHallwayPhysics.add(new Pointer(0, -30, "enter_main_building").setRotation(180)); // Back to main building entrance
        hallwayPhysics.setPointers(pointersHallwayPhysics);
        locations.put("hallway_physics", hallwayPhysics);

        // Location physics classroom door
        Location physicsClassroomDoor = new Location("Physik Klassenzimmer Tür",
                "You are at the door of the physics classroom. The door is unlocked.",
                "images/door_physics.jpeg");
        ArrayList<Pointer> pointersPhysicsDoor = new ArrayList<>();
        pointersPhysicsDoor.add(new Pointer(0, -30, "hallway_physics").setRotation(180)); // Back to hallway
        pointersPhysicsDoor.add(new Pointer(0, -20, "physics_inside").setRotation(0)); // Enter physics classroom
        physicsClassroomDoor.setPointers(pointersPhysicsDoor);
        locations.put("physics_door", physicsClassroomDoor);

        // Location physics classroom inside
        Location physicsClassroomInside = new Location("Physik Klassenzimmer",
                "You are inside the physics classroom. The room is filled with equipment.",
                "images/physics_classroom.jpeg");
        ArrayList<Pointer> pointersPhysicsInside = new ArrayList<>();
        pointersPhysicsInside.add(new Pointer(0, 30, "physics_door").setRotation(180)); // Back to physics classroom door
        physicsClassroomInside.setPointers(pointersPhysicsInside);
        locations.put("physics_inside", physicsClassroomInside);
    }

    public static HashMap<String, Location> getLocations() {
        return locations;
    }

}
