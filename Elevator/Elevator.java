import java.util.PriorityQueue;

public class Elevator {
    int currentFloor;
    Direction direction;
    PriorityQueue<Request> upQueue;
    PriorityQueue<Request> downQueue;

    public Elevator(int currentFloor) {
        this.currentFloor = currentFloor;

        this.direction = Direction.IDLE;

        upQueue = new PriorityQueue<>((a, b) -> a.desiredFloor - b.desiredFloor);

        downQueue =  new PriorityQueue<>((a, b) -> b.desiredFloor - a.desiredFloor);
    }

    public void sendUpRequest(Request upRequest)
    {
        if (upRequest.location == Location.OUTSIDE_ELEVATOR)
        {
            this.upQueue.offer(new Request(upRequest.currentFloor, upRequest.currentFloor, Direction.UP, Location.OUTSIDE_ELEVATOR));

            System.out.println("Appending up request to floor.."+ upRequest.currentFloor);
        }

        this.upQueue.offer(upRequest);

        System.out.println("Appending up request to floor.."+ upRequest.desiredFloor);
    }

    public void sendDownRequest(Request downRequest)
    {
        if ( downRequest.location == Location.OUTSIDE_ELEVATOR)
        {
            this.downQueue.offer(new Request(downRequest.currentFloor, downRequest.currentFloor, Direction.DOWN, Location.OUTSIDE_ELEVATOR));

            System.out.println("Appending down request to floor.."+ downRequest.currentFloor);
        }

        this.downQueue.offer(downRequest);

        System.out.println("Appending down request to floor.."+ downRequest.desiredFloor);
    }

    public void runElevator()
    {
        while(!this.upQueue.isEmpty() || !this.downQueue.isEmpty())
        {
            processRequests();
        }
        System.out.println("Finished all requests....");
        this.direction = Direction.IDLE;
    }

    private void processRequests()
    {
        if(this.direction == Direction.UP || this.direction == Direction.IDLE)
        {
            processUpRequests();
            processDownRequests();
        }
        else
        {
            processDownRequests();
            processUpRequests();
        }
    }

    private void processUpRequests()
    {
        while(!upQueue.isEmpty())
        {
            Request upRequest = this.upQueue.poll();

            this.currentFloor = upRequest.desiredFloor;

            System.out.println("Elevator stopped at" + this.currentFloor);
        }
        if (!downQueue.isEmpty())
        {
            this.direction = Direction.DOWN;
        }
        else
        {
            this.direction = Direction.IDLE;
        }
    }

    private void processDownRequests()
    {
        while(!downQueue.isEmpty())
        {
            Request downRequest = this.downQueue.poll();
            this.currentFloor = downRequest.desiredFloor;

            System.out.println("Elevator stopped at " + this.currentFloor);
        }

        if(!upQueue.isEmpty())
        {
            this.direction = Direction.UP;
        }
        else
        {
            this.direction = Direction.IDLE;
        }
    }


}
