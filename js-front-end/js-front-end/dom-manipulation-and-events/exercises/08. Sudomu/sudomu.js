document.addEventListener('DOMContentLoaded', solve);

function solve() {
    const form = document.getElementById('solutionCheck');
    const table = form.querySelector('table');
    const checkMessage = document.getElementById('check');
    const inputs = form.querySelectorAll('input[type="number"]');

    form.addEventListener('submit', (e) => {
        e.preventDefault();

        const gridSize = Number(document.getElementById('size').value);

        const grid = [];
        let isValid = true;
        for (let row = 0; row < gridSize; row++) {
            const currentRow = [];
            for (let col = 0; col < gridSize; col++) {
                const input = inputs[row * gridSize + col];
                const value = Number(input.value);

                if (!value || value < 1 || value > gridSize) {
                    isValid = false;
                }
                currentRow.push(value);
            }
            grid.push(currentRow);
        }

        for (let i = 0; i < gridSize; i++) {
            const row = new Set(grid[i]);
            const col = new Set(grid.map(row => row[i]));
            if (row.size !== gridSize || col.size !== gridSize) {
                isValid = false;
                break;
            }
        }

        if (gridSize === 9) {
            const subGridSize = Math.sqrt(gridSize);
            for (let startRow = 0; startRow < gridSize; startRow += subGridSize) {
                for (let startCol = 0; startCol < gridSize; startCol += subGridSize) {
                    const subGrid = new Set();
                    for (let row = 0; row < subGridSize; row++) {
                        for (let col = 0; col < subGridSize; col++) {
                            subGrid.add(grid[startRow + row][startCol + col]);
                        }
                    }
                    if (subGrid.size !== gridSize) {
                        isValid = false;
                    }
                }
            }
        }

        if (isValid) {
            table.style.border = '2px solid green';
            checkMessage.textContent = 'Success!';
            checkMessage.style.color = 'green';
        } else {
            table.style.border = '2px solid red';
            checkMessage.textContent = 'Keep trying ...';
            checkMessage.style.color = 'red';
        }
    });

    form.addEventListener('reset', () => {
        table.style.border = '';
        checkMessage.textContent = '';
    });
}