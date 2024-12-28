package Publication;

public class ThisEscape {
    private final int value;
    public ThisEscape(EventSource source) {
        value = 42;
        source.registerListener(new EventListener()
        {
            @Override
            public void onEvent(Event e)
        {
            doSomething(e);
        }
        });
    }
    void doSomething(Event e) {
        // Implementation here
         }
}
