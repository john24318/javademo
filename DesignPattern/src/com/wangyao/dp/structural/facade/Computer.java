package com.wangyao.dp.structural.facade;

/**
 * Facade
 * 意图：
 *      为子系统中的一组接口提供一个一致的界面，Facade模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
 * 适用性：
 *      当你要为一个复杂子系统提供一个简单接口时。
 *      客户程序与抽象类的实现部分之间存在着很大的依赖性。
 *      当你需要构建一个层次结构的子系统时，使用facade模式定义子系统中每层的入口点。
 *            
 * @author wangyao
 * 
 */
public class Computer {
    public static final long BOOT_ADDRESS = 0x0000; //装载启动程序的内存地址
    public static final long BOOT_SECTOR = 0x0000;  //存放启动程序的磁盘地址
    public static final int SECTOR_SIZE = 0x01BE;   //启动程序长度

    private CPU cpu;

    private Memory memory;

    private HardDrive hardDrive;

    public Computer(CPU cpu, Memory memory, HardDrive hardDrive) {
        super();
        this.cpu = cpu;
        this.memory = memory;
        this.hardDrive = hardDrive;
    }

    public void startComputer() {
        cpu.freeze();
        memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
        cpu.jump(BOOT_ADDRESS);
        cpu.execute();
    }

}
