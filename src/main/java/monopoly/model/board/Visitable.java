package monopoly.model.board;

import monopoly.model.Visitor;

public interface Visitable {
    public void accept(Visitor visitor);
}
