package academy.elqoo.java8.defaultmethods;

import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface Shape {

    int getXPos();

    int getYPos();

    void setXPos(int xPOs);

    void setYPos(int yPos);

    default String getName(){
        return "";
    }

	default void move(int i, int j) {
		setXPos(i);
		setYPos(j);
	}

	static void moveXPosWith10(List<AbstractShape> shapes) {
		// TODO Auto-generated method stub
		for(Shape s : shapes) {
			s.setXPos(s.getXPos() + 10);
		}
		
	}
	
	default void notImplementedMethod() {
		throw new NotImplementedException();
	};
	


}
