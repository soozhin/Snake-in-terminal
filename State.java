public interface State {
    public State processTimeElapsed();

    public State processKeyTyped(String event);

    public void paint(View view);
}