package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.entity.Plan;

import java.util.List;

public interface IPlanService {
    public Boolean insert(Plan plan);
    public Boolean update(Plan plan);
    public Boolean delete(int id);

    public Plan getPlan(int id);
    public List<Plan> getPlans();
}
