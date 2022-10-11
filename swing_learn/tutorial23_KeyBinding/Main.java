package swing_learn.tutorial23_KeyBinding;

public class Main{
    public static void main(String[] args) {
        // Key Binding = bind an Action to a KeyStroke
        //               don't require you to click a component to give it focus
        //               all Swing components use Key Bindings
        //               increased flexibility compared to KeyListeners
        //               can assign key strokes to individual Swing components
        //               more difficult to utilize and set up

        Game game = new Game();
    }
}