package monopoly.model.board;

import monopoly.controller.Visitor;

public interface Visitable {
    public void accept(Visitor visitor);
}
