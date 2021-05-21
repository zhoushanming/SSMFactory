package cn.edu.usts.cs2018.dao.mapper;

import cn.edu.usts.cs2018.entity.DrawingMachine;

import java.util.List;

public interface DrawingMachineMapper {
    public int insert(DrawingMachine drawingMachine);
    public int update(DrawingMachine drawingMachine);
    public int delete(int id);

    public DrawingMachine getMachine(int id);
    public List<DrawingMachine> getMachinesByStatus(int status);
    public List<DrawingMachine> getAllMachines();

    public int setAllAsBreakdown();
}
