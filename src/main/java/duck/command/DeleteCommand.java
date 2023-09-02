package duck.command;

import duck.DuckException;
import duck.Storage;
import duck.Ui;
import duck.task.Task;
import duck.task.TaskList;

/**
 * Represents an executable command which deletes a task.
 */
public class DeleteCommand extends Command {
    private int index;

    /**
     * Creates a new delete command.
     * 
     * @param index Index of task to be deleted.
     */
    public DeleteCommand(int index) {
        this.index = index - 1;
    }

    @Override
    public void execute(TaskList tasks, Ui ui,Storage storage) throws DuckException{
        Task tmpTask = tasks.getTask(index);
        tasks.delete(index);
        ui.showDeleteTaskMessage(tmpTask, tasks.getTaskCount());
        storage.deleteTask(index);
    }
}