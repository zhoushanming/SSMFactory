package cn.edu.usts.cs2018.dao.mapper;

import cn.edu.usts.cs2018.entity.Plan;

import java.util.List;

public interface PlanMapper {
    public int insert(Plan plan);
    public int update(Plan plan);
    public int delete(int id);

    public Plan getPlan(int id);
    public List<Plan>getPlans();
}
