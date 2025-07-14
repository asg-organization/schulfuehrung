import java.util.ArrayList;

public class Locations {
    private static ArrayList<Location> locations = new ArrayList<>();

    public static void fillList() {
        // Entrance location #0
        Location entrace = new Location("Eingang", "A dense forest with towering trees.", "images/entrance.jpeg");
        ArrayList<Pointer> pointersEntrance = new ArrayList<>();
        pointersEntrance.add(new Pointer(1, -20, 1).setRotation(0));
        entrace.setPointers(pointersEntrance);
        locations.add(entrace);

        // Location lobby #1
        Location lobby = new Location("Lobby", "A spacious lobby with a grand chandelier.", "images/lobby.jpg");
        ArrayList<Pointer> pointersLobby = new ArrayList<>();
        pointersLobby.add((new Pointer(40, -20, 2)).setRotation(-45));
        lobby.setPointers(pointersLobby);
        locations.add(lobby);

        // Location "enter main building" (door) #2
        Location enterMainBuilding = new Location("Hauptgebäude",
                "You are at the main building's entrance. The door is open and you can enter",
                "images/enter_main_building.jpeg");
        ArrayList<Pointer> pointersEnterMainBuilding = new ArrayList<>();
        pointersEnterMainBuilding.add(new Pointer(-40, -15, 8).setRotation(45));
        pointersEnterMainBuilding.add(new Pointer(15, -5, 3).setRotation(-90));
        enterMainBuilding.setPointers(pointersEnterMainBuilding);
        locations.add(enterMainBuilding);

        // Location "hallway biology chemistry" #3
        Location hallwayBioChem = new Location("Flur Biologie Chemie",
                "You are in the hallway between the biology and chemistry classrooms.",
                "images/hallway_biology_chemistry.jpeg");
        ArrayList<Pointer> pointersHallwayBioChem = new ArrayList<>();
        pointersHallwayBioChem.add(new Pointer(-5, 0, 6).setRotation(0)); // To biology classroom
        pointersHallwayBioChem.add(new Pointer(15, 5, 4).setRotation(-90)); // To chemistry classroom
        hallwayBioChem.setPointers(pointersHallwayBioChem);
        locations.add(hallwayBioChem);

        // Location chemistry classroom #4
        Location chemistryClassroomDoor = new Location("Chemie Klassenzimmer Tür",
                "You are at the door of the chemistry classroom. The door is unlocked.",
                "images/door_chemistry.jpeg");
        ArrayList<Pointer> pointersChemistryDoor = new ArrayList<>();
        pointersChemistryDoor.add(new Pointer(0, -30, 3).setRotation(180)); // Back to hallway
        pointersChemistryDoor.add(new Pointer(0, -20, 3).setRotation(0)); // Enter chemistry classroom
        chemistryClassroomDoor.setPointers(pointersChemistryDoor);
        locations.add(chemistryClassroomDoor);

        // Location chemistry classroom inside #5
        Location chemistryClassroomInside = new Location("Chemie Klassenzimmer",
                "You are inside the chemistry classroom. The room is filled with lab equipment.",
                "images/chemistry_classroom.jpeg");
        ArrayList<Pointer> pointersChemistryInside = new ArrayList<>();
        pointersChemistryInside.add(new Pointer(0, 30, 4).setRotation(180)); // Back to chemistry classroom door
        pointersChemistryInside.add(new Pointer(0, 20, 6).setRotation(90)); // To biology classroom
        chemistryClassroomInside.setPointers(pointersChemistryInside);
        locations.add(chemistryClassroomInside);

        // Location biology classroom door #6
        Location biologyClassroomDoor = new Location("Biologie Klassenzimmer Tür",
                "You are at the door of the biology classroom. The door is unlocked.",
                "images/door_biology.jpeg");
        ArrayList<Pointer> pointersBiologyDoor = new ArrayList<>();
        pointersBiologyDoor.add(new Pointer(0, -30, 4).setRotation(180)); // Back to hallway
        pointersBiologyDoor.add(new Pointer(0, -20, 7).setRotation(0)); // Enter biology classroom
        biologyClassroomDoor.setPointers(pointersBiologyDoor);
        locations.add(biologyClassroomDoor);

        // Location biology classroom inside #7
        Location biologyClassroomInside = new Location("Biologie Klassenzimmer",
                "You are inside the biology classroom. The room is filled with plants and equipment.",
                "images/biology_classroom.jpeg");
        ArrayList<Pointer> pointersBiologyInside = new ArrayList<>();
        pointersBiologyInside.add(new Pointer(0, 30, 6).setRotation(180)); // Back to biology classroom door
        biologyClassroomInside.setPointers(pointersBiologyInside);
        locations.add(biologyClassroomInside);

        // Location "hallway physics" #8
        Location hallwayPhysics = new Location("Flur Physik",
                "You are in the hallway leading to the physics classroom.",
                "images/hallway_physics.jpeg");
        ArrayList<Pointer> pointersHallwayPhysics = new ArrayList<>();
        pointersHallwayPhysics.add(new Pointer(-10, -10, 9).setRotation(0)); // To physics classroom
        pointersHallwayPhysics.add(new Pointer(10, 10, 2).setRotation(180)); // To back to enter main building
        hallwayPhysics.setPointers(pointersHallwayPhysics);
        locations.add(hallwayPhysics);

        // Location physics classroom door #9
        Location physicsClassroomDoor = new Location("Physik Klassenzimmer Tür",
                "You are at the door of the physics classroom. The door is unlocked.",
                "images/door_physics.jpeg");
        ArrayList<Pointer> pointersPhysicsDoor = new ArrayList<>();
        pointersPhysicsDoor.add(new Pointer(0, -30, 8).setRotation(180)); // Back to hallway
        pointersPhysicsDoor.add(new Pointer(0, -20, 10).setRotation(0)); // Enter physics classroom
        physicsClassroomDoor.setPointers(pointersPhysicsDoor);
        locations.add(physicsClassroomDoor);
    }

    public static ArrayList<Location> getLocations() {
        return locations;
    }

}
