package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.List;

public class MachineServiceImpl implements MachineService<Machine> {
    @Override
    public List<? extends Machine> getAll(Class type) {
        MachineProducer<? extends Machine> machineProducer = new MachineProducerImpl();
        if (type.equals(Truck.class)) {
            machineProducer = new TruckProducer();
        } else if (type.equals(Excavator.class)) {
            machineProducer = new ExcavatorProducer();
        } else if (type.equals(Bulldozer.class)) {
            machineProducer = new BulldozerProducer();
        }
        return machineProducer.get();
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (Machine machine : machines) {
            machine.doWork();
        }
    }
}
