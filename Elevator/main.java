public class main {
    public static void main(String[]args)
    {
        Elevator el = new Elevator(0);

        Request upRequest = new Request(0, 5, Direction.UP, Location.INSIDE_ELEVATOR);
        Request uprequest2 = new Request(0, 3, Direction.UP, Location.INSIDE_ELEVATOR);

        Request downReq3 = new Request(4, 0, Direction.DOWN, Location.OUTSIDE_ELEVATOR);

        Request downRequest = new Request(0, 1, Direction.DOWN, Location.INSIDE_ELEVATOR);

        Request downRequest2 = new Request(0, 2, Direction.DOWN, Location.INSIDE_ELEVATOR);

        Request upReq22 = new Request(1, 7, Direction.UP, Location.OUTSIDE_ELEVATOR);

        el.sendUpRequest(upRequest);
        el.sendUpRequest(uprequest2);
        el.sendDownRequest(downReq3);
        el.sendDownRequest(downRequest2);
        el.sendDownRequest(downRequest);

        el.runElevator();

        el.sendUpRequest(upReq22);

        el.runElevator();
    }
}
