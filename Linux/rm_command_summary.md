# Linux `rm` Command Summary

The `rm` command (short for **remove**) is used in Linux to delete files and directories. This document summarizes its behavior and common options.

---

## 🔹 Basic Usage

```bash
rm filename.txt
```

- Deletes a single file.
- **Does not work on directories** without additional options.

---

## 🔸 Common Options

| Option | Full Form | Description |
|--------|-----------|-------------|
| `-r`   | `--recursive` | Recursively deletes directories and their contents |
| `-f`   | `--force`     | Force deletion without prompt or error messages |
| `-i`   | `--interactive` | Ask before every deletion |
| `-v`   | `--verbose`   | Show what is being deleted |

---

## ⚠️ Dangerous Commands

### `rm -r directory/`
- Deletes the directory and everything inside it.
- Will prompt for confirmation (depending on permissions).

### `rm -rf directory/`
- **Forcefully and recursively deletes all contents**.
- **No prompts, no warnings.**
- ⚠️ This command is dangerous and irreversible.

---

## ✅ Safe Practices

- Use `-i` when unsure:
  ```bash
  rm -ri my_folder/
  ```

- Use `trash-cli` or move to trash instead of deleting:
  ```bash
  trash filename.txt
  ```

- Always double-check the path before running `rm -rf`.

---

## 📌 Summary

| Command | Purpose |
|---------|---------|
| `rm file.txt` | Delete file |
| `rm -r folder/` | Recursively delete folder |
| `rm -f file.txt` | Force delete file |
| `rm -rf folder/` | Force and recursively delete folder (no confirmation) |

---

> 💡 Always think twice before using `rm -rf`, especially as `root`.