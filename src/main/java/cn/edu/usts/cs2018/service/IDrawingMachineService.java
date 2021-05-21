package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.entity.DrawingMachine;

import java.util.List;

public interface IDrawingMachineService {
    public Boolean insert(DrawingMachine drawingMachine);
    public Boolean update(DrawingMachine drawingMachine);
    public Boolean delete(int id);

    public DrawingMachine getMachine(int id);
    public List<DrawingMachine> getMachinesByStatus(int status);
    public List<DrawingMachine> getAllMachines();

    public List<DrawingMachine> getReadyMachines();
    public List<DrawingMachine> getProcessingMachines();
    public List<DrawingMachine> getBreakdownMachines();


}
