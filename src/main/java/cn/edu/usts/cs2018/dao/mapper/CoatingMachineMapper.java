package cn.edu.usts.cs2018.dao.mapper;


import cn.edu.usts.cs2018.entity.CoatingMachine;

import java.util.List;

public interface CoatingMachineMapper {
    public int insert(CoatingMachine coatingMachine);
    public int update(CoatingMachine coatingMachine);
    public int delete(int id);

    public CoatingMachine getMachine(int id);
    public List<CoatingMachine> getMachinesByStatus(int status);
    public List<CoatingMachine> getAllMachines();

    public int setAllAsBreakdown();
}
