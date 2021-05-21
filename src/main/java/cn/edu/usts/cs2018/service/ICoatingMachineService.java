package cn.edu.usts.cs2018.service;


import cn.edu.usts.cs2018.entity.CoatingMachine;

import java.util.List;

public interface ICoatingMachineService {
    public Boolean insert(CoatingMachine coatingMachine);
    public Boolean update(CoatingMachine coatingMachine);
    public Boolean delete(int id);

    public CoatingMachine getMachine(int id);
    public List<CoatingMachine> getMachinesByStatus(int status);
    public List<CoatingMachine> getAllMachines();

    public List<CoatingMachine> getReadyMachines();
    public List<CoatingMachine> getProcessingMachines();
    public List<CoatingMachine> getBreakdownMachines();
}
